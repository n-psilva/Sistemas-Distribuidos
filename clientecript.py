from socket import  *

s = socket ()
s.connect(("127.0.0.1",8729))

while True:

  z= 'zenit'
  p= 'polar'
  cripto = ''
  n =0
    
    
  frase = input ("Digite sua frase: ")
  print (frase)
  origem = frase
  
  if len(frase) == 0:
      break
    
  frase=str.encode (frase, "UTF-8")
  print (frase)
  s.send (frase)

  data = s.recv (1024)
  dados = data.decode('utf-8')
  
  print("Frase criptografada: " + dados)
  
  for i in range(len(dados)):
      c = dados[n]
      if c in z:
        c = int(z.find(dados[n]))
        cripto += p[c]
      elif c in p:
        c = int(p.find(dados[n]))
        cripto += z[c]
      else:
        cripto += dados[n]
      n+=1
      
  
  data = cripto
  
  if data==origem:
    print ("A criptografia funciona!")
    print("Frase descriptografada: " + data)
  else:
    print("A criptografia não funciona!")
    

s.close ()
