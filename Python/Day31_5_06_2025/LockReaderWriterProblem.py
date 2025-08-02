""" Q4. Reader-Writer Problem
Implement a simplified reader-writer problem using locks, where multiple readers can access the resource simultaneously, 
but only one writer can access it at a time. """
import threading
import time
import random
shared_data = 0
read_lock = threading.Lock() 
resource_lock = threading.Lock() 
read_count = 0
def reader(reader_id, read_time):
    global read_count
    time.sleep(random.uniform(0.1, 0.5)) 
    with read_lock:
        global read_count
        read_count += 1
        if read_count == 1:
            resource_lock.acquire()  
    print(f"Reader {reader_id} is reading shared_data: {shared_data}")
    time.sleep(read_time)  
    print(f"Reader {reader_id} finished reading")
    with read_lock:
        read_count -= 1
        if read_count == 0:
            resource_lock.release() 
def writer(writer_id, write_time):
    global shared_data
    time.sleep(random.uniform(0.1, 0.5)) 
    print(f"Writer {writer_id} is waiting to write")
    with resource_lock:
        print(f"Writer {writer_id} is writing...")
        shared_data += 1
        time.sleep(write_time) 
        print(f"Writer {writer_id} finished writing new value: {shared_data}")
def ReaderWriter():
    num_readers = int(input("Enter number of readers: "))
    num_writers = int(input("Enter number of writers: "))
    read_time = float(input("Enter read duration (seconds): "))
    write_time = float(input("Enter write duration (seconds): "))
    threads = []
    for i in range(num_readers):
        t = threading.Thread(target=reader, args=(i+1, read_time))
        threads.append(t)
    for i in range(num_writers):
        t = threading.Thread(target=writer, args=(i+1, write_time))
        threads.append(t)
    random.shuffle(threads)
    for t in threads:
        t.start()
    for t in threads:
        t.join()
    print("\nAll readers and writers have finished.")
if __name__ == "__main__":
    ReaderWriter()