# Q5. Implement a script to catch a timeout exception when making a request to a server using the requests library.
import requests
def fetch_data_with_timeout(url, timeout_seconds):
    try:
        print(f"Attempting to fetch data from {url} with a timeout of {timeout_seconds} seconds...")
        response = requests.get(url, timeout=timeout_seconds)
        print("Request successful!")
        print(f"Status Code: {response.status_code}")
        print("Response preview:", response.text[:100]) 
    except requests.exceptions.Timeout:
        print("Request timed out!")
    except requests.exceptions.RequestException as e:
        print("An error occurred during the request.")
        print(f"Error: {e}")
    finally:
        print("Request handling complete.")
fetch_data_with_timeout("https://httpbin.org/delay/5", timeout_seconds=2)

# pip install requests