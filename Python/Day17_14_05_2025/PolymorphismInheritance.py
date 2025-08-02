""" Q7. Polymorphism in Inheritance:
Write a program to demonstrate polymorphism by creating a base class Media with a method play() that prints "Playing media." 
Create two derived classes, Audio and Video, that override the play() method to print "Playing audio" and "Playing video," respectively. 
Write a function that takes a list of Media objects and calls the play() method on each. """
class Media:
    def play(self):
        print("Playing media.")
class Audio(Media):
    def play(self):
        print("Playing audio.")
class Video(Media):
    def play(self):
        print("Playing video.")
def play_all(media_list):
    for media in media_list:
        media.play()
media1 = Audio()
media2 = Video()
media3 = Media()
media_objects = [media1, media2, media3]
play_all(media_objects)