class Entrance {

    static signIn(loginElement, passwordElement) {
        if (this.isCorrect([loginElement, passwordElement])) {
            let login = document.getElementById(loginElement);
            let password = document.getElementById(passwordElement);
            let data = "Basic " + btoa(login.value + ", " + password.value);
            this.doRequest(data, "Authorization", "/interviewer/sign_in", "GET");
        } else {
            alert("Проверьте данные!")
        }
    }

    static signUp(nicknameElement, loginElement, passwordElement) {
        if (this.isCorrect([loginElement, passwordElement])) {
            let nickname = document.getElementById(nicknameElement);
            let login = document.getElementById(loginElement);
            let password = document.getElementById(passwordElement);
            let data = "nickname=" + nickname.value + "&login=" + login.value + "&password=" + password.value;
            this.doRequest(data, null, "/interviewer/sign_up", "POST");
        } else {
            alert("Проверьте данные!")
        }
    }

    static doRequest(data, header, URL, requestType) {
        let xmlHttp = new XMLHttpRequest();
        xmlHttp.open(requestType, URL, true);
        xmlHttp.setRequestHeader("Content-Type", "text/plain; charset=UTF-8");
        if (header == null) {
            xmlHttp.send(data);
        } else {
            xmlHttp.setRequestHeader(header, data);
            xmlHttp.send();
        }

        xmlHttp.onload = function () {
            let result = xmlHttp.responseText;
            if (result != null && result !== "") {
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