import pyaudio
import wave
import sys
CHUNK=1024
def talk(op=''):
    p = pyaudio.PyAudio()

    stream = p.open(format=p.get_format_from_width(op.getsampwidth()),
                    channels=op.getnchannels(),
                    rate=op.getframerate(),
                    output=True)

    data = op.readframes(CHUNK)

    while len(data) > 0:
        stream.write(data)
        data = op.readframes(CHUNK)

    stream.stop_stream()
    stream.close()

    p.terminate()
def numeros():
    import math
    unidad=[" ","n1","n2","n3","n4","n5","n6","n7","n8","n9","n10"]
    esp=[" ","n11","n12","n13","n14","n15","n16","n17","n18","n19"]
    decenas = ["","n10","n20", "n30","n40","n50", "n60","n70", "n80", "n90"]
    centenas = ["n100","n100.2","n200","n300","n400","n500","n600","n700","n800","n900"]
    
    local="./nu/"
    print("**Suma de numeros Menor de 1000**")
    su1=int(input("Digite el primer numero:"))
    su2=int(input("Digite el segundo numero:"))
    num=su1+su2
    
    if (num < 9):
        op=wave.open(local+unidad[num]+".wav")
        talk(op)
    elif (num==10):
        op=wave.open(local+"n10.wav")
        talk(op)
    elif (num>11 and num<20):
        num=num-10
        op=wave.open(local+esp[num]+".wav")
        talk(op)
    elif (num >= 20 and num < 100):
        u= (num%10)
        d=int(num/10)
        op=wave.open(local+decenas[d]+".wav")
        if (u==0):
            talk(op)
        else:
             op1=wave.open(local+"y.wav")
             op2=wave.open(local+unidad[u]+".wav")
             [talk(op),talk(op1),talk(op2)]
    elif (num >=100 and num <=1000):
        if(num==1000):
            op=wave.open(local+"n1000.wav")
            talk(op)
        elif(num<1000):
                c=int(num/100)
                d=int((num-(c*100))/10)
                u=int(num-(c*100+d*10))
                if(u==0):
                    if(d==0):
                       op=wave.open(local+centenas[0]+".wav")
                       talk(op)
                    else:
                        op1=wave.open(local+centenas[c]+".wav")
                        op2=wave.open(local+decenas[d]+".wav")
                        [talk(op1),talk(op2)]
                else:
                     if(d == 1) and (u == 1,2,3,4,5,6,7,8,9):

                        op=wave.open(local+centenas[c]+".wav")
                        op1=wave.open(local+esp[u]+".wav")
                        [talk(op),talk(op1)]
                     else:
                            op=wave.open(local+centenas[c]+".wav")
                            op1=wave.open(local+decenas[d]+".wav")
                            op2=wave.open(local+"y.wav")
                            op3=wave.open(local+unidad[u]+".wav")
                            [talk(op),talk(op1),talk(op2),talk(op3)]

numeros()



                         
