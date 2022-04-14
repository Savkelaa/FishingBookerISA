import React from "react";
import pic from "../../Assets/img/profile.jpg";
import { Image } from "react-bootstrap";

export default function AdminProfilePicture({ logedAdmin }) {
  console.log("logedAdmin", logedAdmin);

  return (
    <div className="col-md-3 border-right">
      <div className="d-flex flex-column align-items-center text-center p-3 py-5">
        <img
          className="rounded-circle mt-5"
          width="150px"
          src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"
        />
        <span className="font-weight-bold">
          {logedAdmin.name} {logedAdmin.surname}
        </span>
        <span className="text-black-50">{logedAdmin.email}</span>
        <span> </span>
      </div>
    </div>
  );
}
