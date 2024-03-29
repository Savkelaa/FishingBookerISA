import React, { useEffect, useState } from "react";
import NavbarLogin from "../Components/Common/NavbarLogin";
import Footerr from "../Components/Common/Footerr";
import Login from "../Components/Common/Login";
import userServices from "../Services/UserServices/UserServices";
import { Link, Route, Switch, useHistory, useLocation } from "react-router-dom";

function LoginContainer() {
  const [client, setClient] = useState();
  const [admin, setAdmin] = useState();
  const [cottageOwner, setCottageOwner] = useState();
  const [boatOwner, setBoatOnwer] = useState();
  const [instructor, setInstructor] = useState();

  const history = useHistory();

  function logInClient(email, password) {
    userServices
      .logInClient(email, password)
      .then((data) => {
        if (data.status === 204) setClient();
        else {
          userServices
            .logInClient(email, password)
            .then((data) => {
              setClient(data.data);
              localStorage.setItem("Client", JSON.stringify(data.data));

              var clientt = JSON.parse(localStorage.getItem("Client"));
              if (clientt.activated == "true" && clientt.deleted == "false") {
                if (Object.keys(clientt).length !== 0) {
                  history.push("/clientHomePage");
                  console.log("sucessfuly logedOn a client");
                  alert("sucessfuly logedOn a client");
                }
              } else if (Object.keys(clientt).length == 0) {
              } else {
                alert("Admin need to activate your account");
              }
            })
            .catch((error) => console.log(`error`, error));
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again", error);
      });
  }

  function logInAdmin(email, password) {
    userServices
      .logInAdmin(email, password)
      .then((data) => {
        if (data.status === 204) setAdmin();
        else {
          userServices
            .logInAdmin(email, password)
            .then((data) => {
              setAdmin(data.data);
              localStorage.setItem("Admin", JSON.stringify(data.data));
              var adminn = JSON.parse(localStorage.getItem("Admin"));
              if (adminn.email == "nikolaakv@gmail.com") {
                history.push("/predefAdminHomePage");
              } else if (adminn.firstTimeLoged == "true") {
                history.push("/changePassword");
              } else if (adminn.deleted == "false") {
                if (Object.keys(adminn).length !== 0) {
                  history.push("/adminHomePage");
                  console.log("sucessfuly logedOn a admin");
                  alert("sucessfuly logedOn a admin");
                }
              } else if (Object.keys(adminn).length == 0) {
              } else {
                alert("Admin need to activate your account");
              }
            })
            .catch((error) => console.log(`error`, error));
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again", error);
      });
  }

  function logInCottageOwner(email, password) {
    userServices
      .logInCottageOwner(email, password)
      .then((data) => {
        if (data.status === 204) setCottageOwner();
        else {
          userServices
            .logInCottageOwner(email, password)
            .then((data) => {
              setCottageOwner(data.data);
              localStorage.setItem("CottageOwner", JSON.stringify(data.data));
              var cottageOwnerr = JSON.parse(
                localStorage.getItem("CottageOwner")
              );
              if (
                cottageOwnerr.activated == "true" &&
                cottageOwnerr.deleted == "false"
              ) {
                if (Object.keys(cottageOwnerr).length !== 0) {
                  history.push("/cottageOwnerHomePage");
                  console.log("sucessfuly logedOn a cottage owner");
                  alert("sucessfuly logedOn a cottage owner");
                }
              } else if (Object.keys(cottageOwnerr).length == 0) {
              } else {
                alert("Admin need to activate your account");
              }
            })
            .catch((error) => console.log(`error`, error));
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again", error);
      });
  }

  function logInBoatOwner(email, password) {
    userServices
      .logInBoatOwner(email, password)
      .then((data) => {
        if (data.status === 204) setBoatOnwer();
        else {
          userServices
            .logInBoatOwner(email, password)
            .then((data) => {
              setBoatOnwer(data.data);
              localStorage.setItem("BoatOwner", JSON.stringify(data.data));

              var boatOwnerr = JSON.parse(localStorage.getItem("BoatOwner"));
              if (
                boatOwnerr.activated == "true" &&
                boatOwnerr.deleted == "false"
              ) {
                if (Object.keys(boatOwnerr).length !== 0) {
                  history.push("/boatOwnerHomePage");
                  console.log("sucessfuly logedOn a BoatOnwer");
                  alert("sucessfuly logedOn a BoatOnwer");
                }
              } else if (Object.keys(boatOwnerr).length == 0) {
              } else {
                alert("Admin need to activate your account");
              }
            })
            .catch((error) => console.log(`error`, error));
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again", error);
      });
  }

  function logInInstructor(email, password) {
    userServices
      .logInInstructor(email, password)
      .then((data) => {
        if (data.status === 204) setInstructor();
        else {
          userServices
            .logInInstructor(email, password)
            .then((data) => {
              setInstructor(data.data);
              localStorage.setItem("Instructor", JSON.stringify(data.data));
              var instructorr = JSON.parse(localStorage.getItem("Instructor"));
              if (
                instructorr.activated == "true" &&
                instructorr.deleted == "false"
              ) {
                if (Object.keys(instructorr).length !== 0) {
                  history.push("/instructorHomePage");
                  console.log("sucessfuly logedOn a instructor", data.data);
                  alert("sucessfuly logedOn a instructor");
                }
              } else if (Object.keys(instructorr).length == 0) {
              } else {
                alert("Admin need to activate your account");
              }
            })
            .catch((error) => console.log(`error`, error));
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again", error);
      });
  }
  // localStorage.setItem("InstructorsFollow", JSON.stringify([]));
  // localStorage.setItem("CottagesFollow", JSON.stringify([]));
  // localStorage.setItem("BoatsFollow", JSON.stringify([]));
  return (
    <div>
      <NavbarLogin></NavbarLogin>

      <Login
        instructor={instructor}
        cottageOwner={cottageOwner}
        boatOwner={boatOwner}
        admin={admin}
        client={client}
        logInClientHandler={logInClient}
        logInAdminHandler={logInAdmin}
        logInInstructorHandler={logInInstructor}
        logInCottageOwnerHandler={logInCottageOwner}
        logInBoatOwnerHandler={logInBoatOwner}
      ></Login>
      <Footerr></Footerr>
    </div>
  );
}

export default LoginContainer;
