import React from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import Profile from "../Components/Common/Profile";
import AdministratorHomeButtons from "../Components/Common/AdministratorHomeButtons";
import ProfilePicture from "../Components/Common/ProfilePicture";
import ProfileLabels from "../Components/Common/ProfileLabels";
import PredefAdminProfilePicture from "../Components/HomePageComponents/PredefAdminProfilePicture";
import PredefAdminProfileLabels from "../Components/HomePageComponents/PredefAdminProfileLabels";
import PredefAdministratorHomeButtons from "../Components/HomePageComponents/PredefAdminHomeButtons";

export default function PredefAdminHomePageContainer() {
  return (
    <div>
      <Navbarr></Navbarr>
      <div className="container rounded bg-white mt-5 mb-5">
        <div className="row">
          <PredefAdminProfilePicture></PredefAdminProfilePicture>
          <PredefAdminProfileLabels></PredefAdminProfileLabels>
          <PredefAdministratorHomeButtons></PredefAdministratorHomeButtons>
        </div>
      </div>
      <Footerr></Footerr>
    </div>
  );
}
