import React, { useRef } from "react";

export default function ProfileLabels({
  logedCottageOwner,
  sendCottageOwnerDeleteRequestHandler,
  updateCottageOwnerHandler,
}) {
  console.log("logedCottageOwner", logedCottageOwner);

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
              placeholder={logedCottageOwner.name}
            />
          </div>
          <div className="col-md-6">
            <label className="labels">Surname</label>
            <input
              ref={surname}
              type="text"
              className="form-control"
              placeholder={logedCottageOwner.surname}
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
              placeholder={logedCottageOwner.address}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">City</label>
            <input
              ref={city}
              type="text"
              className="form-control"
              placeholder={logedCottageOwner.city}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">Country</label>
            <input
              ref={country}
              type="text"
              className="form-control"
              placeholder={logedCottageOwner.country}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">Email</label>
            <input
              ref={email}
              type="text"
              className="form-control"
              placeholder={logedCottageOwner.email}
            />
          </div>

          <div className="col-md-12">
            <label className="labels">Number</label>
            <input
              ref={number}
              type="text"
              className="form-control"
              placeholder={logedCottageOwner.number}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">Explanation of Registration</label>
            <input
              ref={explanation}
              type="text"
              className="form-control"
              placeholder={logedCottageOwner.explanation}
            />
          </div>
          
        </div>

        <div className="mt-5 text-center">
          <button
            className="btn btn-success profile-button"
            type="button"
            onClick={() => {
              logedCottageOwner.name = name.current.value;
              logedCottageOwner.surname = surname.current.value;
              logedCottageOwner.address = address.current.value;
              logedCottageOwner.city = city.current.value;
              logedCottageOwner.country = country.current.value;
              logedCottageOwner.email = email.current.value;
              logedCottageOwner.number = number.current.value;
              logedCottageOwner.explanation = explanation.current.value;
              

              localStorage.setItem(
                "CottageOwner",
                JSON.stringify(logedCottageOwner)
              );

              updateCottageOwnerHandler(logedCottageOwner);
            }}
          >
            Update Profile
          </button>
          <button
            onClick={() => {
              if (deleteReason.current.value == "") {
                alert("You need to fill filed.");
              } else {
                logedCottageOwner.deleteReason = deleteReason.current.value;
                sendCottageOwnerDeleteRequestHandler(logedCottageOwner);
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
