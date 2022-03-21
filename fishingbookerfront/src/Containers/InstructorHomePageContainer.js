import React from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import background from "../Assets/img/background.jpg";
import Profile from "../Components/Common/Profile";
import "../Assets/css/profile.css";

export default function InstructorHomePage() {
  return (
    <div>
      <Navbarr></Navbarr>
      <Profile></Profile>
      <Footerr></Footerr>
    </div>
  );
}
