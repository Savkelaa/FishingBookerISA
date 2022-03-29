import React, { useState, useEffect } from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import "../App.css";

import userServices from "../Services/UserServices/UserServices";
import Instructors from "../Components/Common/Instructors";

function AllInstrucotrsContainer() {
  const [instructors, setInstructors] = useState([]);

  useEffect(() => {
    userServices
      .getAllInstructors()
      .then((data) => {
        setInstructors(data.data);
      })
      .catch((error) => console.log(`error`, error));
  }, []);

  return (
    <div>
      <Navbarr></Navbarr>
      <Instructors instructors={instructors}></Instructors>
      <Footerr></Footerr>
    </div>
  );
}

export default AllInstrucotrsContainer;
