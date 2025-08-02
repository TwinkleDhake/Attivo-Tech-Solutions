""" Q1. write a python code such that the user input given in text must be produced as output in voice and vice-versa. """
import pyttsx3
import speech_recognition as sr
# text-to-speech conversion
engine = pyttsx3.init()
def text_to_speech(text):
    """ convert text to speech """
    print("Hello, I am converting text to speech. Please wait a moment.")
    engine.say(text)
    engine.runAndWait()
    print("conversion completed.")
    return None
# speech-to-text conversion
def speech_to_text():
    """ convert speech to text """
    print("Hello, I am converting speech to text. Please wait a moment.")
    r = sr.Recognizer()
    with sr.Microphone() as source:
        print("Listening...Please speak now.")
        audio = r.listen(source)
        try:
            text = r.recognize_google(audio)
            print(f"You said: {text}")
            return text
        except sr.UnknownValueError:
            print("I couldn't understand that audio. Please try again.")
            return None
        except sr.RequestError:
            print("Could not request results from google speech recognition service. Please check your internet connection.")
            return None
        except Exception as e:
            print(f"An unexpected error occurred: {e}")
            return None
        finally:
            print("conversion completed.")
            return None
# Main program
def TextToSpeechToText():
    while True:
        print("\nChoose an option: \n1. Text to Speech \n2. Speech to Text \n3. Exit")
        choice = input("Enter your choice: ")
        if choice == '1':
            user_text = input("Enter text to convert to speech: ")
            text_to_speech(user_text)
        elif choice == '2':
            speech_to_text()
        elif choice == '3':
            print("Exiting the program.")
            break
        else:
            print("Invalid choice. Please try again.")
if __name__ == "__main__":
    TextToSpeechToText()