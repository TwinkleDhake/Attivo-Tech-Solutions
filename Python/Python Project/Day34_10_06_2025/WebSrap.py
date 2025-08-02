import requests
from bs4 import BeautifulSoup
# URL of the Apple homepage stored in 'url'
url = 'https://www.apple.com/'
# Sends a GET request to the Apple homepage
response = requests.get(url)
# Checks if the request was successful
if response.status_code == 200:
    # Parses the page content
    soup = BeautifulSoup(response.content, 'html.parser')
    # Extracts all text within <h2> tags
    headings = soup.find_all('h2')
    print('Main Headings from Apple Homepage:')
    for heading in headings:
        print(heading.get_text(strip=True))
else:
    print(f'Failed to retrieve the page. Status code: {response.status_code}')