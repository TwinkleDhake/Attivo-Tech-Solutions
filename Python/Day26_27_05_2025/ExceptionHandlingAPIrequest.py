""" Q10. Write a Python program that sends an API request to a given URL and validates the response. 
Use the requests library to fetch the response.
Your program should:
Raise a custom InvalidResponseError if the response status code is not 200.
Raise a custom EmptyResponseError if the response body is empty.
Catch any requests.exceptions.RequestException for network-related issues.
Use a try-except block to manage all exceptions and log them to a file named error_log.txt. """
import requests
import logging
logging.basicConfig(filename='error_log.txt', level=logging.ERROR, format='%(asctime)s - %(message)s')
class InvalidResponseError(Exception): pass
class EmptyResponseError(Exception): pass
def fetch_url(url):
    try:
        response = requests.get(url)
        if response.status_code != 200:
            raise InvalidResponseError(f"Status code: {response.status_code}")
        if not response.text.strip():
            raise EmptyResponseError("Empty response body")
        print("Request successful!")
        print("Response preview:", response.text[:200], "...")
    except requests.exceptions.RequestException as e:
        logging.error(f"Network error: {e}")
        print("Network error. See error_log.txt.")
    except (InvalidResponseError, EmptyResponseError) as e:
        logging.error(f"Validation error: {e}")
        print("Validation error. See error_log.txt.")
    except Exception as e:
        logging.error(f"Unexpected error: {e}")
        print("Unexpected error. See error_log.txt.")
fetch_url("https://jsonplaceholder.typicode.com/posts/1")
