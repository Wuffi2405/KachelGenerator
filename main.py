import xml.etree.ElementTree as ET
from FileManager import FileManager
from flask import Flask, redirect, render_template, request
import os


fileManager = FileManager()

app = Flask(__name__)


@app.route("/", methods = ['GET'])
def index():

    path = os.getcwd() + 'static\svg templates'
    return render_template("index.html")


@app.route("/allocate", methods = ['GET'])
def allocate():

    uuid = fileManager.allocateTemplate(int(request.args.get("templateID")))
    if uuid == "":
        return redirect("/")
    return redirect("/edit?folder=" + uuid)


@app.route("/edit", methods = ['GET'])
def editor(imgUUID=0):

    if imgUUID == 0:
        redirect("/")

    folderUUID = request.args.get('folder')

    if folderUUID not in [f for f in os.listdir("static/temp/") if os.path.isdir(os.path.join("static/temp/", f))]:
        return redirect("/")

    return render_template("editor.html", folder=folderUUID)



"""
SESSION_COOKIE_SECURE = True
REMEMBER_COOKIE_SECURE = True

SESSION_COOKIE_HTTPONLY = True
REMEMBER_COOKIE_HTTPONLY = True

"""