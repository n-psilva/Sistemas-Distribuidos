from threading import Thread, Condition
import time
import random

cond = Condition()


def proca ():
  global cond
  with cond:
    cond.wait()
    cond.notify()
    time.sleep(random.randint(1,3))
    print ("is ", end="")
    time.sleep(random.randint(1,3))
    print ("La ", end="")
    time.sleep(random.randint(1,3))

def procb ():
 global cond
 with cond:
  time.sleep(random.randint(1,3))
  print ("Sou ", end="")
  cond.wait()
  time.sleep(random.randint(1,3))
  print ("Sal", end="")
  time.sleep(random.randint(1,3))
  cond.notify()

def procc ():
 global cond

 with cond:
  cond.notify()
  time.sleep(random.randint(1,3))
  print ("ma", end="")
  cond.wait()
  time.sleep(random.randint(1,3))
  print ("le", end="")
  time.sleep(random.randint(1,3))



threads = []
threads.append (Thread(target=proca))
threads.append (Thread(target=procb))
threads.append (Thread(target=procc))
for i in range (3):
 threads[i].start()

for i in range (3):
 threads[i].join ()

print ()
