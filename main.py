import xml.etree.ElementTree as ET

from flask import Flask, render_template, request, redirect


app = Flask(__name__)
app.secret_key = "warum gibt es das"

print(__name__)

@app.route("/", methods = ['GET'])
def hello_world(_svg_upload=""):
    print(_svg_upload)
    return render_template("index.html", svg_upload=_svg_upload)


tree = ET.parse('static/test.svg')
root = tree.getroot()

elementList = []

todoList = [root]
while(len(todoList)):
    nextList = []
    for element in todoList:
        attributes = element.attrib
        if "{http://www.spd-bautzen.de/kg}element" in attributes:
            print("found", element, attributes)
            elementList.append(element)

        for child in element:
            nextList.append(child)
    todoList = nextList


elementList[0].text = "fhsfhsaFHSLFSHAdf"
tree.write('output.svg')
