from socket import  *

s = socket ()
s.connect(("127.0.0.1",8729))

while True:

  cpf = input ("Digite cpf: ")
  
  if len(cpf) == 0:
    break
    
  cpf=str.encode (cpf, "UTF-8")
  print (cpf)
  s.send (cpf)

  data = s.recv (1024)
  
  print(data.decode('utf-8'))
    

s.close ()
