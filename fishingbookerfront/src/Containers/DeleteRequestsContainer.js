import React, { useState, useEffect } from "react";
import DeleteRequests from "../Components/Common/DeleteRequests";
import Footerr from "../Components/Common/Footerr";
import Navbarr from "../Components/Common/Navbarr";
import userServices from "../Services/UserServices/UserServices";

export default function DeleteRequestsContainer() {
  const [instructorDeleteRequests, setInstructorDeleteRequests] = useState([]);
  const [boatOwnerDeleteRequests, setBoatOwnerDeleteRequests] = useState([]);
  const [cottageOwnerDeleteRequests, setCottageOwnerDeleteRequests] = useState(
    []
  );
  const [adminDeleteRequests, setAdminDeleteRequests] = useState([]);
  const [clientDeleteRequests, setClientDeleteClient] = useState([]);

  useEffect(() => {
    userServices
      .getAllInstructorDeleteRequests()
      .then((data) => {
        setInstructorDeleteRequests(data.data);
      })
      .catch((error) => console.log(`error`, error));

    userServices
      .getAllBoatOwnerDeleteRequests()
      .then((data) => {
        setBoatOwnerDeleteRequests(data.data);
      })
      .catch((error) => console.log(`error`, error));

    userServices
      .getAllCottageOwnerDeleteRequests()
      .then((data) => {
        setCottageOwnerDeleteRequests(data.data);
      })
      .catch((error) => console.log(`error`, error));

    userServices
      .getAllAdminDeleteRequests()
      .then((data) => {
        setAdminDeleteRequests(data.data);
      })
      .catch((error) => console.log(`error`, error));

    userServices
      .getAllClientDeleteRequests()
      .then((data) => {
        setClientDeleteClient(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  function removeInstructor(instructor) {
    userServices
      .removeInstructor(instructor)
      .then((data) => {
        if (data.status === 204) instructorDeleteRequests([]);
        else {
          userServices
            .getAllInstructorDeleteRequests()
            .then((data) => {
              setInstructorDeleteRequests(data.data);
            })
            .catch((error) => console.log(`error`, error));
          console.log("sucessfuly deleted Instructor");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  function removeInstructorDeleteRequest(instructor) {
    userServices
      .removeInstructorDeleteRequest(instructor)
      .then((data) => {
        if (data.status === 204) instructorDeleteRequests([]);
        else {
          userServices
            .getAllInstructorDeleteRequests()
            .then((data) => {
              setInstructorDeleteRequests(data.data);
            })
            .catch((error) => console.log(`error`, error));
          console.log("sucessfuly deleted Instructor delete request");
        }
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <DeleteRequests
        instructorDeleteRequests={instructorDeleteRequests}
        boatOwnerDeleteRequests={boatOwnerDeleteRequests}
        cottageOwnerDeleteRequests={cottageOwnerDeleteRequests}
        adminDeleteRequests={adminDeleteRequests}
        clientDeleteRequests={clientDeleteRequests}
        removeInstructorHandler={removeInstructor}
        removeInstructorDeleteRequestHandler={removeInstructorDeleteRequest}
      ></DeleteRequests>
      <Footerr></Footerr>
    </div>
  );
}
