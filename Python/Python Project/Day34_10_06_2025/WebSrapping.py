""" Q1. Write a Python script to scrape the titles of the latest articles from the homepage of the Python.org website. 
Display the scraped titles as a list in the console.
Hints:
Use the requests library to fetch the website's content.
Use the BeautifulSoup library to parse the HTML.
Look for elements with class widget-title (or other relevant classes) in the HTML to find the titles. """
import requests
from flask import Flask, request, render_template_string
from bs4 import BeautifulSoup
from urllib.parse import urljoin
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
import threading
import webbrowser
import os
app = Flask(__name__)
def scrape_titles(url):
    """response = requests.get(url)
    if response.status_code == 200:
        soup = BeautifulSoup(response.text, 'html.parser')
        titles = []
        for item in soup.find_all('a', class_='widget-title'):
            titles.append(item.get_text(strip=True))
        return titles
    else:
        return f"Failed to retrieve the page. Status code: {response.status_code}" """
    chrome_options = Options()
    chrome_options.add_argument("--headless")
    chrome_options.add_argument("--disable-gpu")
    chrome_options.add_argument("--no-sandbox")
    chrome_options.add_argument("window-size=1920x1080")
    chrome_options.add_argument("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) "
                           "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36")
    try:
        chromedriver_path = r"E:\Attivo Trainning\Technical Videos\Java_Python\Python\Python Daily Practice\Python Project\Day34_10_06_2025\chromedriver.exe"
        service = Service(executable_path=chromedriver_path)
        driver = webdriver.Chrome(service=service, options=chrome_options)
        driver.get(url)
        soup = BeautifulSoup(driver.page_source, "html.parser")
        driver.quit()
        selectors = [
            ".widget-title",
            ".blog-widget li a",
            ".list-recent-posts li a",
            ".event-widget li a",
            "a.head",
            "h2 a",
            "h3 a",
            "article h2 a",
            "article h3 a",
            "a.article-title"
        ]
        titles = []
        seen_texts = set()
        for selector in selectors:
            for el in soup.select(selector):
                text = el.get_text(strip=True)
                if text and text not in seen_texts:
                    seen_texts.add(text)
                    href = el.get("href")
                    link = urljoin(url, href) if href else None
                    titles.append((text, link))
        return titles
    except Exception as e:
        return f"Failed to fetch the page: {e}"
@app.route("/", methods=["GET", "POST"])
def index():
    titles = []
    error = None
    url = "https://www.python.org"
    if request.method == "POST":
        url_input = request.form.get("url", "").strip()
        if url_input:
            if url_input.startswith("www."):
                url = "https://" + url_input
            elif not url_input.startswith("http://") and not url_input.startswith("https://"):
                url = "https://" + url_input
            else:
                url = url_input
        result = scrape_titles(url)
        if isinstance(result, str):
            error = result
        else:
            titles = result
    return render_template_string('''
        <!doctype html>
        <title>Article Title Scraper</title>
        <h1>Scrape article titles from a website</h1>
        <form method="post">
            URL to scrape:
            <input type="text" name="url" placeholder="https://www.python.org" style="width:300px" />
            <input type="submit" value="Scrape" />
        </form>
        {% if error %}
            <p style="color:red;">{{ error }}</p>
        {% endif %}
        {% if titles %}
            <h2>Titles and Links from {{ url }}</h2>
            <ul>
            {% for title, link in titles %}
                <li>
                    {% if link %}
                        <a href="{{ link }}" target="_blank">{{ title }}</a>
                    {% else %}
                        {{ title }}
                    {% endif %}
                </li>
            {% endfor %}
            </ul>
        {% endif %}
    ''', titles=titles, error=error, url=url)
def open_browser():
    webbrowser.open_new("http://localhost:8080")
if __name__ == "__main__":
    if os.environ.get("WERKZEUG_RUN_MAIN") == "true":
        threading.Timer(1.5, open_browser).start()
    app.run(host="0.0.0.0", port=8080, debug=True)