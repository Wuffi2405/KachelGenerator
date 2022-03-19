import os
import uuid
import shutil

class FileManager:

    def __init__(self):
        pass

    def allocateTemplate(self, template_id):
        uuidString = str(uuid.uuid4().hex)
        path = os.getcwd() + "/static/temp/" + uuidString
        print(path)
        os.mkdir(path)

        shutil.copy2("static\svg templates\Vorlage1.svg", "static/temp/" + uuidString + "/tempimg.svg")

        return uuidString