from json import JSONDecodeError
import xml.etree.ElementTree as ET

from flask import Flask, jsonify, render_template, request, redirect
from editing import Editing
from element import Element
from FileManager import FileManager

import glob

app = Flask(__name__)
fileManager = FileManager()


@app.route("/", methods=['GET'])
def hello_world(_svg_upload=""):
    print(_svg_upload)
    return render_template("index.html", svg_upload=_svg_upload)


@app.route("/editor", methods=['GET'])
def editor():

    # check if we editing or not
    if request.args.get('id') is None:
        templates = [x[7:] for x in glob.glob("static/*.svg")]
        return render_template("editor.html", templates=templates)
    try:
        svgName = request.args.get('id')
        userFoldUUID = fileManager.allocateTemplate(svgName)
        image = 'static/temp/' + userFoldUUID + '/' + svgName
        sharepic = Editing(image)
        elements = [Element(element) for element in sharepic.loadElements()]
        return render_template("editor.html", image=image, elements=elements)
    except Exception as ex:
        print(ex)
        return redirect("/editor")
#
# handle ajax request for updating sharepics
#


@app.route("/editor/process", methods=['POST'])
def process():
    image = request.form['image']
    id = request.form['id']
    value = request.form['value']

    sharepic = Editing(image)
    sharepic.update(id, image, value)

    return jsonify({'url': image})


# elementList[0].text = "fhsfhsaFHSLFSHAdf"
# tree.write('output.svg')

if __name__ == "__main__":

    app.secret_key = "warum gibt es das"

    # load default sharepic
    sharepic = Editing('static/test.svg')

    print(__name__)
