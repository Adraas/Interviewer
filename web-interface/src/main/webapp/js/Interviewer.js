class Interviewer {

    static lastUpdatingDate = null;

    static updateTableValues(URL, tableId, cookie) {
        let xmlHttp = new XMLHttpRequest();
        xmlHttp.open("GET", URL, true);
        xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        xmlHttp.setRequestHeader("Model-version", this.lastUpdatingDate);
        xmlHttp.setRequestHeader("Cookie", cookie);
        xmlHttp.send();
        xmlHttp.onload = function () {
            let lastUpdatingDate = xmlHttp.getResponseHeader("Last-updating-date");
            if (lastUpdatingDate !== Interviewer.lastUpdatingDate) {
                Interviewer.lastUpdatingDate = lastUpdatingDate;
                Interviewer.deleteOldTableValues(tableId);
                let tableValues = xmlHttp.getResponseHeader("Table-values");
                document.getElementById(tableId).append(tableValues);
            }
        }
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
        xmlHttp.open("GET", URL, true);
        xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        xmlHttp.setRequestHeader("Cookie", cookie);
        xmlHttp.send();
    }
}