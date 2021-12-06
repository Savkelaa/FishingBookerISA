import React from "react";
import pic from "../../Assets/img/profile.jpg";
import { Image } from "react-bootstrap";

export default function ProfilePicture() {
  return (
    <div className="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
      <div className="card h-100">
        <div className="card-body">
          <div className="account-settings">
            <div className="user-profile">
              <div className="user-avatar"></div>
              <h5 className="user-name">Name</h5>
              <div class="user-avatar">
                <Image src={pic} rounded />
              </div>
            </div>
            <div className="about">
              <h5>About</h5>
              <p>Description</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
