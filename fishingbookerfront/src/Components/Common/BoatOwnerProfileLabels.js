import React, { useRef } from "react";

export default function ProfileLabels({
  logedBoatOwner,
  sendBoatOwnerDeleteRequestHandler,
  updateBoatOwnerHandler,
}) {
  console.log("logedBoatOwner", logedBoatOwner);

  const deleteReason = useRef();
  const name = useRef();
  const surname = useRef();
  const address = useRef();
  const city = useRef();
  const country = useRef();
  const email = useRef();
  const number = useRef();
  const explanation = useRef();
  const shortBiography = useRef();

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
              ref={name}
              type="text"
              className="form-control"
              placeholder={logedBoatOwner.name}
            />
          </div>
          <div className="col-md-6">
            <label className="labels">Surname</label>
            <input
              ref={surname}
              type="text"
              className="form-control"
              placeholder={logedBoatOwner.surname}
            />
          </div>
        </div>
        <div className="row mt-3">
          <div className="col-md-12">
            <label className="labels">Address</label>
            <input
              ref={address}
              type="text"
              className="form-control"
              placeholder={logedBoatOwner.address}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">City</label>
            <input
              ref={city}
              type="text"
              className="form-control"
              placeholder={logedBoatOwner.city}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">Country</label>
            <input
              ref={country}
              type="text"
              className="form-control"
              placeholder={logedBoatOwner.country}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">Email</label>
            <input
              ref={email}
              type="text"
              className="form-control"
              placeholder={logedBoatOwner.email}
            />
          </div>

          <div className="col-md-12">
            <label className="labels">Number</label>
            <input
              ref={number}
              type="text"
              className="form-control"
              placeholder={logedBoatOwner.number}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">Explanation of Registration</label>
            <input
              ref={explanation}
              type="text"
              className="form-control"
              placeholder={logedBoatOwner.explanation}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">Short Biography</label>
            <input
              ref={shortBiography}
              type="text"
              className="form-control"
              placeholder={logedBoatOwner.shortBiography}
            />
          </div>
        </div>

        <div className="mt-5 text-center">
          <button
            className="btn btn-success profile-button"
            type="button"
            onClick={() => {
              logedBoatOwner.name = name.current.value;
              logedBoatOwner.surname = surname.current.value;
              logedBoatOwner.address = address.current.value;
              logedBoatOwner.city = city.current.value;
              logedBoatOwner.country = country.current.value;
              logedBoatOwner.email = email.current.value;
              logedBoatOwner.number = number.current.value;
              logedBoatOwner.explanation = explanation.current.value;
              logedBoatOwner.shortBiography = shortBiography.current.value;

              localStorage.setItem(
                "BoatOwner",
                JSON.stringify(logedBoatOwner)
              );

              updateBoatOwnerHandler(logedBoatOwner);
            }}
          >
            Update Profile
          </button>
          <button
            onClick={() => {
              if (deleteReason.current.value == "") {
                alert("You need to fill filed.");
              } else {
                logedBoatOwner.deleteReason = deleteReason.current.value;
                sendBoatOwnerDeleteRequestHandler(logedBoatOwner);
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
