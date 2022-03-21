import os
import uuid
import shutil

class FileManager:

    def __init__(self):
        pass

    def allocateTemplate(self, templateID):

        if len([f for f in os.listdir("static/temp/") if os.path.isdir(os.path.join("static/temp/", f))]) >= 20:
            return ""

        uuidString = str(uuid.uuid4().hex)
        path = os.getcwd() + "/static/temp/" + uuidString
        os.mkdir(path)

        templateFiles = [f for f in os.listdir("static/svg templates/") if os.path.isfile(os.path.join("static/svg templates/", f))]
        print("CREATED NEW WORKSPACE FOLDER FOR TEMPLATE", templateFiles[templateID % len(templateFiles)])
        shutil.copy2("static/svg templates/" + templateFiles[templateID % len(templateFiles)], "static/temp/" + uuidString + "/tempimg.svg")

        return uuidString