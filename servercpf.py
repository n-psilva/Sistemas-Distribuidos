from socket import *
from threading import *


def validador(num):
  
  dig=[]
  for i in range(len(num)-2):
    dig +=num[i]
  
  soma1 = (int(dig[0]) * 10) + (int(dig[1]) * 9) + (int(dig[2]) * 8) + (int(dig[3]) * 7) + (int(dig[4]) * 6 )+ (int(dig[5]) * 5) + (int(dig[6]) * 4) + (int(dig[7]) * 3) + (int(dig[8]) * 2)

  resto1= soma1 % 11
  if resto1 > 2 :
    resto1 = 11 - resto1
  else:
    resto1 = 0
  dig.append(str(resto1))


  soma2 = (int(dig[0]) * 11) + (int(dig[1]) * 10) + (int(dig[2]) * 9) + (int(dig[3]) * 8) + (int(dig[4]) * 7) + (int(dig[5]) * 6 )+ (int(dig[6]) * 5) + (int(dig[7]) * 4) + (int(dig[8]) * 3) + (int(dig[9]) * 2)

  resto2 = soma2 % 11
  if resto2 > 2 :
    resto2 = 11 - resto2
  else:
    resto2 = 0
  dig.append(str(resto2))

  dig = ''.join(dig)

  if dig == num:
    resp = "VALIDO"
    return resp
  else:
    resp = "INVALIDO"
    return resp



def trata_conn(conn,cliente):
  
  while True:
   
    data = conn.recv (4096)

    if not data:
        break

    print (str(cliente)+" me mandou "+ data.decode('utf-8') )
    
    cpf = data.decode('utf-8')
    
    if len(cpf) == 14 and cpf[:3].isdigit() and cpf[3] == '.'and cpf[4:7].isdigit() and cpf[7] == '.' and cpf[8:11].isdigit() and cpf[11] == '-' and cpf[12:].isdigit():
        print(cpf)
        cpf = ''.join(cpf.split('.'))
        cpf = ''.join(cpf.split('-'))
        data = validador(cpf)
        conn.send (str.encode ("CPF "+ data, "UTF-8"))
  
    elif cpf.isdigit() and len(cpf) == 11:
        data = validador(cpf)
        conn.send (str.encode ("CPF "+ data, "UTF-8"))
    else:
        data = 'Digite apenas numeros ou no formato xxx.xxx.xxx-xx'
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
