class Interviewer {

    static lastUpdatingDate = null;

    static updateTableValues(URL, tableId, cookie) {
        let xmlHttp = new XMLHttpRequest();
        let dateVariableFormat = "last-updating-date=";
        xmlHttp.onload = function () {
            let response = xmlHttp.responseText;
            if (response.trim() !== "") {
                if (response.startsWith(dateVariableFormat)) {
                    let responseDate = response.split(dateVariableFormat)[1].split("&")[0];
                    Interviewer.lastUpdatingDate = moment(responseDate, "EEE MMM dd HH:mm:ss zzz yyyy");
                    Interviewer.deleteOldTableValues(tableId);
                    let responseTable = response.split("&");
                    if (responseTable.length === 2) {
                        let tableValues = responseTable[1].split("response-table=")[1];
                        document.getElementById(tableId).append(tableValues);
                    }
                }
            }
        };
        xmlHttp.open("POST", URL, true);
        xmlHttp.setRequestHeader("Content-Type", "text/plain; charset=UTF-8");
        xmlHttp.setRequestHeader("Cookie", cookie);
        xmlHttp.send(dateVariableFormat + Interviewer.lastUpdatingDate.millisecond);
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