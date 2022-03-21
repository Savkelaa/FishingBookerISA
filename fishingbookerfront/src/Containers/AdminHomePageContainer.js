import React from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import Profile from "../Components/Common/Profile";
import AdministratorHomeButtons from "../Components/Common/AdministratorHomeButtons";
import ProfilePicture from "../Components/Common/ProfilePicture";
import ProfileLabels from "../Components/Common/ProfileLabels";

export default function AdminHomePageContainer() {
  return (
    <div>
      <Navbarr></Navbarr>
      <div className="container rounded bg-white mt-5 mb-5">
        <div className="row">
          <ProfilePicture></ProfilePicture>
          <ProfileLabels></ProfileLabels>
          <AdministratorHomeButtons></AdministratorHomeButtons>
        </div>
      </div>
      <Footerr></Footerr>
    </div>
  );
}
