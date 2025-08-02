""" Q6. Multithreaded Web Scraper
Write a multithreaded Python program that downloads the content of multiple web pages concurrently. 
Use threading and requests modules. """
import threading
import requests
def normalize_url(url):
    if not url.startswith(("http://", "https://")):
        return "http://" + url
    return url
def download_content(url):
    try:
        response = requests.get(url)
        print(f"[{threading.current_thread().name}] Fetched {url} - Status: {response.status_code}, Content length: {len(response.text)}")
    except requests.RequestException as e:
        print(f"[{threading.current_thread().name}] Failed to fetch {url}: {e}")
urls = []
n = int(input("Enter the number of URLs: "))
for i in range(n):
    url = input(f"Enter URL {i+1}: ").strip()
    url = normalize_url(url)
    urls.append(url)
threads = []
for url in urls:
    thread = threading.Thread(target=download_content, args=(url,))
    threads.append(thread)
    thread.start()
for thread in threads:
    thread.join()
print("Finished downloading all pages.")