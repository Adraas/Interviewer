class Interviewer {

    static lastUpdatingDate = null;

    static updateTableValues(URL, tableId, cookie) {
        let xmlHttp = new XMLHttpRequest();
        xmlHttp.onload = function () {
            let response = xmlHttp.responseText;
            if (response.trim() !== "") {
                let responseData = response.split(dateVariableFormat)[1].split("&");
                Interviewer.lastUpdatingDate = Date.parse(responseData[0]);
                Interviewer.deleteOldTableValues(tableId);
                let tableValues = responseData[1];
                document.getElementById(tableId).append(tableValues);
            }
        };
        xmlHttp.open("POST", URL, true);
        xmlHttp.setRequestHeader("Content-Type", "text/plain; charset=UTF-8");
        xmlHttp.setRequestHeader("Cookie", cookie);
        let dateVariableFormat = "last-updating-date=";
        xmlHttp.send(dateVariableFormat + Interviewer.lastUpdatingDate.toString());
    }

    static deleteOldTableValues(tableId) {
        let element = document.getElementById(tableId);
        let prefix = "tr";
        let postfix = 0;
        let childElement = document.getElementById(prefix + String(postfix));
        while (childElement !== null) {
            element.parentNode.removeChild(childElement);
            postfix++;
            childElement = document.getElementById(prefix + String(postfix));
        }
    }

    static navigateTo(URL, cookie) {
        let xmlHttp = new XMLHttpRequest();
        xmlHttp.open("POST", URL, true);
        xmlHttp.setRequestHeader("Content-Type", "text/plain; charset=UTF-8");
        xmlHttp.setRequestHeader("Cookie", cookie);
        xmlHttp.send();
    }
}