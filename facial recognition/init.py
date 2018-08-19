import recog as rec
import talk as ta
import trainner as tr

def init():
    x=int(input("**Programa de reconocimiento facial**\n *Para tener acceso al programa necesita realizar un reconocimiento facial*\n *Para realizar reconocimiento presione (1)*\n *Si ya realizo anterior mente el reconocimiento presiones cualquier tecla* "))

    if (x==1):
        rec.facial_recog()
        tr.trainner()
        x=(input("**Ya se a creado su reconocimiento facial**"))
    else:
        reco=rec.recog()    
        if (reco):
            x=(input("**ha sido reconocido"))
            ta.numeros()  
   
init()
