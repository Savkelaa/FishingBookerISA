import React from "react";
import Navbarr from "../Components/Common/Navbarr";
import Footerr from "../Components/Common/Footerr";
import Profile from "../Components/Common/Profile";
import AdministratorHomeButtons from "../Components/Common/AdministratorHomeButtons";
import AdminProfilePicture from "../Components/HomePageComponents/AdminProfilePicture";
import AdminProfileLabels from "../Components/HomePageComponents/AdminProfileLabels";
import userServices from "../Services/UserServices/UserServices";

export default function AdminHomePageContainer() {
  var logedAdmin = JSON.parse(localStorage.getItem("Admin"));

  function updateAdmin(admin) {
    userServices
      .updateAdmin(admin)
      .then((data) => {
        console.log("sucessfuly updated Admin");
      })
      .catch((error) => {
        console.log("Something wen't wrong try again");
      });
  }

  return (
    <div>
      <Navbarr></Navbarr>
      <div className="container rounded bg-white mt-5 mb-5">
        <div className="row">
          <AdminProfilePicture logedAdmin={logedAdmin}></AdminProfilePicture>
          <AdminProfileLabels
            updateAdminHandler={updateAdmin}
            logedAdmin={logedAdmin}
          ></AdminProfileLabels>
          <AdministratorHomeButtons></AdministratorHomeButtons>
        </div>
      </div>
      <Footerr></Footerr>
    </div>
  );
}
