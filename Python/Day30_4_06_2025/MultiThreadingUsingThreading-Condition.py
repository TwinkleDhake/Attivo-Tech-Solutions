""" Q5. Using threading.Condition
Create a program where one thread produces items (integers from 1 to 10) and 
puts them in a shared list, and another thread consumes those items. 
Use threading.Condition to synchronize the producer and consumer. """
import threading
import time
shared_list = []
condition = threading.Condition()
def producer():
    for i in range(1, 11): 
        with condition:
            shared_list.append(i)
            print(f"Produced: {i}")
            condition.notify() 
            time.sleep(0.5)
def consumer():
    count = 0
    while count < 10: 
        with condition:
            while not shared_list:
                condition.wait() 
            item = shared_list.pop(0)
            print(f"Consumed: {item}")
            count += 1
            time.sleep(0.5)
producer_thread = threading.Thread(target=producer)
consumer_thread = threading.Thread(target=consumer)
producer_thread.start()
consumer_thread.start()
producer_thread.join()
consumer_thread.join()
print("Production and consumption complete.")