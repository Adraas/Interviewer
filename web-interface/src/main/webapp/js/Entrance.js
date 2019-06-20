class Entrance {

    static signIn(loginElement, passwordElement) {
        if (this.isCorrect([loginElement, passwordElement])) {
            let login = document.getElementById(loginElement);
            let password = document.getElementById(passwordElement);
            let data = btoa(login + ", " + password);
            this.doRequest(data, "Authorization", "/interviewer/sign_in", "GET");
        } else {
            alert("Проверьте данные!")
        }
    }

    static signUp(fullNameElement, loginElement, passwordElement) {
        if (this.isCorrect([loginElement, passwordElement])) {
            let nickname = document.getElementById(fullNameElement);
            let login = document.getElementById(loginElement);
            let password = document.getElementById(passwordElement);
            let data = "nickname=" + nickname + "&login=" + login + "&password=" + password;
            this.doRequest(data, "Registration", "/interviewer/sign_up", "POST");
        } else {
            alert("Проверьте данные!")
        }
    }

    static doRequest(data, header, URL, requestType) {
        let xmlHttp = new XMLHttpRequest();
        xmlHttp.open(requestType, URL, true);
        xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
        xmlHttp.setRequestHeader(header, data);
        xmlHttp.send();

        xmlHttp.onload = function () {
            let result = xmlHttp.getResponseHeader("Result");
            if (result != null || result !== "") {
                alert(result);
            }
        };
    }

    static isCorrect(elements) {
        for (let i = 0; i < elements.length; i++) {
            let isEmpty = document.getElementById(elements[i]).value.trim() === "";
            if (isEmpty) {
                return false;
            }
        }
        return true;
    }
}