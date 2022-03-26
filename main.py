from FileManager import FileManager
from flask import Flask, redirect, render_template, request


fileManager = FileManager()
app = Flask(__name__)


@app.route("/", methods = ['GET'])
def index():
    msg = request.args.get("msg")
    return render_template("index.html", message=msg)


@app.route("/allocate", methods = ['GET'])
def allocate():
    try:
        uuid = fileManager.allocateTemplate(int(request.args.get("templateID")))
        return redirect("/edit?folder=" + uuid)
    except Exception as ex:
        return redirect("/?msg=" + str(ex))
    

@app.route("/edit", methods = ['GET'])
def editor():
    try:
        folderUUID = request.args.get('folder')
        if folderUUID not in fileManager.getTempFolders():
            raise Exception("Folder does not exist")
        return render_template("editor.html", folder=folderUUID)
    except Exception as ex:
        return redirect("/?msg=" + str(ex))


"""

TODO save cookies

SESSION_COOKIE_SECURE = True
REMEMBER_COOKIE_SECURE = True

SESSION_COOKIE_HTTPONLY = True
REMEMBER_COOKIE_HTTPONLY = True

@app.before_first_request
def before_first():
    session["auth"] = generate_password_hash(
        password=request.remote_addr + request.user_agent.string)

from werkzeug.security import generate_password_hash, check_password_hash

def before_req():
    if not (session.get("auth&quot") and check_password_hash(session.get("auth&quot"), request.remote_addr + request.user_agent.string)):
        logging.warning(f"No/Wrong session cookie by IP {request.remote_addr}&quot
        session.clear()
        session["auth"] = generate_password_hash(
            password=request.remote_addr + request.user_agent.string)


"""