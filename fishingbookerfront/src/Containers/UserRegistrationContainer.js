import React, { useState, useEffect } from "react";
import { useLocation, useHistory } from "react-router-dom";
import Navbarr_Home from "../Components/Common/Navbarr-Home";
import Footerr from "../Components/Common/Footerr";

import UserServices from "../Services/UserServices/UserServices";
import userServices from "../Services/UserServices/UserServices";
import RegistrationForm from "../Components/Common/RegistrationForm";

function UserRegistrationContainer() {
  const [client, setClient] = useState([]);
  const [boatOwner, setBoatOwner] = useState([]);
  const [instructor, setInstructor] = useState([]);
  const [cottageOwner, setCottageOwner] = useState([]);
  const [admin, setAdmin] = useState([]);

  function addClient(user) {
    userServices
      .createClient(user)
      .then((data) => {
        if (data.status === 204) setClient([]);
        else {
          setClient(data.data.content);
          console.log("sucessfuly added a client");
          alert("sucessfuly added a Client");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again", error);
      });
  }

  // function addAdmin(user) {
  //   userServices
  //     .createAdmin(user)
  //     .then((data) => {
  //       if (data.status === 204) setAdmin([]);
  //       else {
  //         setAdmin(data.data.content);
  //         console.log("sucessfuly added a admin");
  //       }
  //     })
  //     .catch((error) => {
  //       console.log("Something wen't wrong try again");
  //     });
  // }

  function addBoatOwner(boatOwner) {
    userServices
      .createBoatOwner(boatOwner)
      .then((data) => {
        if (data.status === 204) setBoatOwner([]);
        else {
          setBoatOwner(data.data.content);
          console.log("sucessfuly added a boat Owner");
          alert("sucessfuly added a boat Owner");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  function addInstructor(instrictor) {
    userServices
      .createInstructor(instrictor)
      .then((data) => {
        if (data.status === 204) setInstructor([]);
        else {
          setInstructor(data.data.content);
          console.log("sucessfuly added a instructor");
          alert("sucessfuly added a instructor");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  function addCottageOwner(cottageOwner) {
    userServices
      .createCottageOwner(cottageOwner)
      .then((data) => {
        if (data.status === 204) setCottageOwner([]);
        else {
          setCottageOwner(data.data.content);
          console.log("sucessfuly added a cottage owner.");
          alert("sucessfuly added a cottage owner.");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <Navbarr_Home></Navbarr_Home>
      <RegistrationForm
        addClientHandler={addClient}
        addCottageOwnerHandler={addCottageOwner}
        addInstructorHandler={addInstructor}
        addBoatOwnerHandler={addBoatOwner}
        //   addAdminHandler={addAdmin}
      ></RegistrationForm>
      <Footerr></Footerr>
    </div>
  );
}

export default UserRegistrationContainer;
