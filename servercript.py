from socket import *
from threading import *


def trata_conn(conn,cliente):
  
  while True:
    
    z= 'zenit'
    p= 'polar'
    cripto = ''
    n =0
    
    data = conn.recv (4096)

    if not data:
        break

    print (str(cliente)+" me mandou "+ data.decode('utf-8') )
    
    dados = data.decode('utf-8')
    
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
    
    print("Mensagem criptografada: " + data)

    conn.send (str.encode (data))

  print ("Fim da conexao com "+ str(cliente))

  conn.close



s = socket ()

host = "0.0.0.0"
porta = 8729
s.bind ((host, porta))
s.listen (10)

while True:
        (conn, cliente) = s.accept ()
        print ("Recebi a conexao de "+str(cliente))

        t = Thread (target=trata_conn, args=(conn,cliente))
        t.start()
