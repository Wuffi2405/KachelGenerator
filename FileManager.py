import os
import uuid
import shutil

class FileManager:

    def __init__(self):
        pass

    def allocateTemplate(self, templateID):


        uuidString = str(uuid.uuid4().hex)
        path = os.getcwd() + "/static/temp/" + uuidString
        os.mkdir(path)

        templateFiles = [f for f in os.listdir("static/svg templates/") if os.path.isfile(os.path.join("static/svg templates/", f))]
        print("CREATED NEW WORKSPACE FOLDER FOR TEMPLATE", templateFiles[templateID])
        shutil.copy2("static/svg templates/" + templateFiles[templateID], "static/temp/" + uuidString + "/tempimg.svg")

        return uuidString