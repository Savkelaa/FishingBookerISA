import React, { useRef } from "react";

export default function ProfileLabels({
  logedInstructor,
  sendInstructorDeleteRequestHandler,
}) {
  console.log("logedInstructor", logedInstructor);

  const deleteReason = useRef();

  return (
    <div className="col-md-5 border-right">
      <div className="p-3 py-5">
        <div className="d-flex justify-content-between align-items-center mb-3">
          <h4 className="text-right">Profile Settings</h4>
        </div>
        <div className="row mt-2">
          <div className="col-md-6">
            <label className="labels">First Name</label>
            <input
              type="text"
              className="form-control"
              placeholder="Enter first name"
              // value={logedInstructor.name}
            />
          </div>
          <div className="col-md-6">
            <label className="labels">Surname</label>
            <input
              type="text"
              className="form-control"
              placeholder="Enter surname"
              //value={logedInstructor.surname}
            />
          </div>
        </div>
        <div className="row mt-3">
          <div className="col-md-12">
            <label className="labels">Address</label>
            <input
              type="text"
              className="form-control"
              placeholder="Enter address"
              // value={logedInstructor.address}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">City</label>
            <input
              type="text"
              className="form-control"
              placeholder="Enter city"
              // value={logedInstructor.city}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">Country</label>
            <input
              type="text"
              className="form-control"
              placeholder="Enter country"
              //  value={logedInstructor.country}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">Email</label>
            <input
              type="text"
              className="form-control"
              placeholder="Enter email address"
              //    value={logedInstructor.email}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">Password</label>
            <input
              type="text"
              className="form-control"
              placeholder="Enter password"
            />
          </div>
          <div className="col-md-12">
            <label className="labels">Number</label>
            <input
              type="text"
              className="form-control"
              placeholder="Enter phone number"
              //   value={logedInstructor.number}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">Explanation of Registration</label>
            <input
              type="text"
              className="form-control"
              placeholder="Enter explanation"
              //  value={logedInstructor.explanation}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">Short Biography</label>
            <input
              type="text"
              className="form-control"
              placeholder="Enter short biography"
              //   value={logedInstructor.shortBiography}
            />
          </div>
        </div>

        <div className="mt-5 text-center">
          <button className="btn btn-success profile-button" type="button">
            Update Profile
          </button>
          <button
            // onClick={(e) => {
            //   if (deleteReason.current.value == "") {
            //     alert("You need to fill filed.");
            //   } else {
            //     logedInstructor.deleteReason = deleteReason.current.value;
            //     sendInstructorDeleteRequestHandler({ logedInstructor });
            //   }
            // }}

            onClick={() => {
              if (deleteReason.current.value == "") {
                alert("You need to fill filed.");
              } else {
                logedInstructor.deleteReason = deleteReason.current.value;
                sendInstructorDeleteRequestHandler(logedInstructor);
              }
            }}
            className="btn btn-danger profile-button"
            type="button"
          >
            Delete Profile
          </button>
          <input
            ref={deleteReason}
            type="refusalReason"
            className="form-control"
            id="refusalReason"
          />
          Enter the reason for deletion
        </div>
      </div>
    </div>
  );
}
