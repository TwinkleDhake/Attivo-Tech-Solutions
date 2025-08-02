# Q6. Implement a function to validate a file format (e.g., .csv) and raise a custom exception for invalid formats.
# custom exception
class InvalidFileFormatError(Exception):
    def __init__(self, filename, expected_format):
        self.filename = filename
        self.expected_format = expected_format
        super().__init__(f"Invalid file format for '{filename}'. Expected a '{expected_format}' file.")
# validation function
def validate_file_format(filename, expected_format=".csv"):
    if not filename.lower().endswith(expected_format.lower()):
        raise InvalidFileFormatError(filename, expected_format)
    print(f"'{filename}' is a valid {expected_format} file.")
try:
    validate_file_format("data.txt")  # This raises an exception
except InvalidFileFormatError as e:
    print(f"Error: {e}")