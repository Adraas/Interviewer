class Interviewer {

    static updateDataSectionValues(url, cookie) {
        let dataSectionId = "data_section";
        let xmlHttp = new XMLHttpRequest();
        xmlHttp.onload = function () {
            let response = xmlHttp.responseText;
            if (response.trim() !== "") {
                Interviewer.deleteOldDataSectionValues(dataSectionId);
                let responseValue = response.split("response-data=");
                if (responseValue.length === 2) {
                    let dataValue = responseValue[1].split("")[1];
                    let parser = new DOMParser();
                    let elementFromString = parser.parseFromString(dataValue, "text/html");
                    document.getElementById(dataSectionId).appendChild(elementFromString);
                }
            }
        };
        xmlHttp.open("POST", url, true);
        xmlHttp.setRequestHeader("Content-Type", "text/plain; charset=UTF-8");
        xmlHttp.setRequestHeader("Cookie", cookie);
        xmlHttp.send("request=update-data-table");
    }

    static deleteOldDataSectionValues(dataSectionId) {
        let childElements = window.document.getElementById(dataSectionId).childNodes;
        for (let i = 0; i < childElements.length; i++) {
            window.document.removeChild(childElements[i]);
        }
    }

    static openElement(url, request) {
        let xmlHttp = new XMLHttpRequest();
        xmlHttp.onload = function () {
            window.open().document.writeln(xmlHttp.responseText);
        };
        xmlHttp.open("POST", url, true);
        xmlHttp.send(request);
    }
}