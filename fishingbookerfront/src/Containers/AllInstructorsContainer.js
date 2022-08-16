import React, { useState, useEffect } from "react";
import Navbar from "../Components/Common/Navbarr-Home";
import Footerr from "../Components/Common/Footerr";
import "../App.css";

import userServices from "../Services/UserServices/UserServices";
import Instructors from "../Components/Common/Instructors";

function AllInstrucotrsContainer() {
  const [instructors, setInstructors] = useState([]);

  useEffect(() => {
    userServices
      .getAllNotDeletedInstructors()
      .then((data) => {
        setInstructors(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  function updateInstructor(instructor) {
    userServices
      .updateInstructor(instructor)
      .then((data) => {
        console.log("sucessfuly updated Instructor");
        console.log("INSTRUCTORRRR", instructor);

        alert("sucessfuly updated Instructor");
        userServices
          .getAllNotDeletedInstructors()
          .then((data) => {
            setInstructors(data.data);
          })
          .catch((error) => console.log(`error`, error));
      })
      .catch((error) => {
        alert("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <Navbar></Navbar>
      <Instructors
        instructors={instructors}
        updateInstructorHandler={updateInstructor}
      ></Instructors>
      <Footerr></Footerr>
    </div>
  );
}

export default AllInstrucotrsContainer;
