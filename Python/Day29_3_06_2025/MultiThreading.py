import threading
lock = threading.Lock()
shared_resource = 0
def increment():
    global shared_resource
    with lock:  # Automatically acquires and releases the lock
        local_copy = shared_resource
        local_copy += 1
        shared_resource = local_copy
threads = [threading.Thread(target=increment) for _ in range(100)]
for thread in threads:
    thread.start()
    thread.join()
print(f"Final value: {shared_resource}")