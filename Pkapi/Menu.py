import sys,sqlite3
import opc1 , tico, pktype, pkbirth, pkexpo,attach
import dbcreator
def Menu():
    print("1. Agregar Pokemon \n 2. Ver Pokemones.\n 3. Reportes.\n 4. Exportar Pokemon\n 5. Exportar Mapa\n 6. Salir")
    opc= int(input("Ingrese su opcion:"))
    if (opc == 1):
       dbcreator.dbcreator()
       opc1.opc1()
       print("Quiere volver al menu (s/n):")
       sn= input("Digite su respuesta:")
       if sn.lower() == "s":
           Menu()
       else:
            sys.exit()
    elif(opc == 2):
         db=sqlite3.connect('pk.db')
         cursor=db.cursor()
         sentencia="SELECT * FROM pkdata;"
         cursor.execute(sentencia)
         pk = cursor.fetchall()
         print("+{:-<20}+{:-<20}+{:-<20}+{:-<10}+{:-<20}+{:-<20}+{:-<40}+{:-<40}+".format( "", "","", "", "", "","",""))

         print("|{:^20}|{:^20}|{:^20}|{:^10}|{:^20}|{:^20}|{:^40}|{:^40}|".format("Nombre", "Tipo", "Signo Zodiacal","sagre", "Fecha nacimiento","Comida","Latitud","Longitud"))
         print("+{:-<20}+{:-<20}+{:-<20}+{:-<10}+{:-<20}+{:-<20}+{:-<40}+{:-<40}+".format("", "", "", "","", "", "", "",))
 
 
         for nombre, tipo, signo_zodiacal, sangre, fecha_nacimiento,comida,Latitud,Longitud in pk:
             print("|{:^20}|{:^20}|{:^20}|{:^10}|{:^20}|{:^20}|{:^40}|{:^40}|".format(nombre, tipo, signo_zodiacal, sangre, fecha_nacimiento,comida,Latitud,Longitud))
	
 
         print("+{:-<20}+{:-<20}+{:-<20}+{:-<10}+{:-<20}+{:-<20}+{:-<40}+{:-<40}+".format("", "", "", "","", "", "", ""))
         Menu()
    elif(opc == 3):
        print("1.Cumpleaño por mes\n 2.Pokemones por tipo\n 3. Comida por tipo\n 4.atras")
        opc=int(input("Digite su opcion:")) 
        if opc== 1:
           pkbirth.birth()
           Menu()
        elif opc ==2:
            pktype.type()
            Menu()
        elif opc ==3:
           tico.tico()
           Menu()
    elif(opc == 4):
        pkexpo.expo()
        Menu()
    elif(opc == 5):
        attach.atta()
        Menu()
    elif(opc == 6):
        sys.exit()
        
Menu()
