import requests,json,sqlite3
url= ('http://pokeapi.co/api/v2/pokemon/')
import sqlite3,os
db= sqlite3.connect('pk.db')
cursor= db.cursor()
def opc1():
        signo = ["Capricornio", "Acuario", "Piscis", "Aries", "Tauro", "Géminis", "Cáncer", "Leo", "Virgo", "Libra", "Escorpio", "Sagitario"]
        pkname= input("Ingrese el nombre del pokemon:").lower()
        pkurl= url + pkname
        data = getdata(pkurl)
        dataname= data.get('name')
        datatype=[types['type']['name'] for types in data['types']]
        datastr= str(datatype)
        if (dataname == pkname):
            day= int(input("Escriba el dia nacimiento:"))
            month= int(input("Escriba el mes nacimiento(en numero):"))
            year=str(input("Esceiba el año de nacimiento:"))
            Lat= float(input("Latitud (de donde fue capturado):"))
            Lon= float(input("Longitud (de donde fue capturado):"))
            ffood= input("Comida Favorita:")
            tblood= input("Tipo de Sangre:")
            if (day >=21 or day <=20) and (month==3 or month==4):
                    sig= (signo[3])
            elif (day >=21 or day <=21) and (month==4 or month==5):
                    sig= (signo[4])
            elif (day >=22 or day <=22) and (month==6 or month==7):
                    sig= (signo[5])
            elif (day >=22 or day <=21) and (month==5 or month==6):
                    sig= (signo[6])
            elif (day >=24 or day <=23) and (month==9 or month==10):
                    sig= (signo[9])
            elif (day >=23 or day <=23) and (month==7 or month==8):
                     sig= (signo[7])
            elif (day >=24 or day <=23) and (month==8 or month==9):
                    sig= (signo[8])
            elif (day >=24 or day <=22) and (month==10 or month==11):
                    sig= (signo[10])
            elif (day >=21 or day <=18) and (month==1 or month==2):
                    sig= (signo[1])
            elif (day >=23 or day <=21) and (month==11 or month==12):
                    sig= (signo[11])
            elif (day >=22 or day <=20) and (month==1 or month==12):
                    sig= (signo[0])
            elif (day >=19 or day <=20) and (month==2 or month==3):
                     sig= (signo[2])

            da=str(day)
            mo=str(month)
            burn=(da +"/"+ mo +"/"+ year)
            sentencia= "INSERT INTO pkdata(nombre, tipo, signo_zodiacal, sangre , fecha_nacimiento, comida, Latitud, Longitud) VALUES (?,?,?,?,?,?,?,?)"
            cursor.execute(sentencia, [pkname, datastr, sig,tblood, burn, ffood,Lat,Lon])
            db.commit()
            print("Guardado!")
def getdata(pkurl=' '):
    try:
        pkdata = {
            "name":'',
            "types":''
        }
        r = requests.get (pkurl)
        data= r.json()
        pkdata ['name']= data['name']
        pkdata ['types']= data['types']
        return pkdata
        
    except OSError:
        print("Nombre mal escrito")
