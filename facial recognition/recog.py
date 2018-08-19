import cv2
import numpy as np
from PIL import Image
import os
def facial_recog():
    cam = cv2.VideoCapture(0)
    detector = cv2.CascadeClassifier('haarcascade_frontalface_default.xml')

    Id = input('Escribe los ultimos 4 digitos de tu matricula:')
    facialnum = 0
    print(cam)
    while(True):
        ret, img = cam.read()
        gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
        faces = detector.detectMultiScale(gray, 1.3, 5)
        for (x,y,w,h) in faces:
            print(x,y,w,h)
            cv2.rectangle(img,(x,y),(x+w,y+h),(255,0,0),2)

            facialnum=facialnum+1
            cv2.imwrite("facial/User."+Id +'.'+ str(facialnum) + ".jpg", gray[y:y+h,x:x+w])

            cv2.imshow('Analizando tu rostro', img)

        if cv2.waitKey(100) & 0xFF == ord('q'):
            break

        elif facialnum > 50:
            break

    cam.release()
    cv2.destroyAllWindows()

def recog():
    recognizer = cv2.face.LBPHFaceRecognizer_create()
    recognizer.read('trai/trainner.yml')
    cascadePath = "haarcascade_frontalface_default.xml"
    faceCascade = cv2.CascadeClassifier(cascadePath)

    cam = cv2.VideoCapture(0)
    isIdentifyed = None
    
    font = cv2.FONT_HERSHEY_SIMPLEX
    while isIdentifyed == None:
        ret, im = cam.read()
        gray = cv2.cvtColor(im, cv2.COLOR_BGR2GRAY)
        faces = faceCascade.detectMultiScale(gray, 1.2,5)
        for(x, y, w, h) in faces:
            cv2.rectangle(im,(x, y),(x+w, y+h),(225, 0, 0), 2)
            Id, conf = recognizer.predict(gray[y:y+h,x:x+w])
            if(conf<50):
                if(Id==1):
                    Id=("User.1")
                    isIdentifyed = True
                elif(Id==2):
                    Id=("User.2")
                    isIdentifyed = True
            else:
                Id="Buscando..."
            cv2.putText(im,str(Id), org=(x,y+h),fontFace=font, color=(255,255,255), fontScale=1)
            if isIdentifyed== True:
                break
        cv2.imshow('Reconociendo',im)
        if isIdentifyed== True:
            break
        if cv2.waitKey(10) & 0xFF==ord('q'):
            break


    cam.release()
    cv2.destroyAllWindows()

    return isIdentifyed
