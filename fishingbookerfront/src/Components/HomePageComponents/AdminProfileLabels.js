import React, { useRef } from "react";

export default function AdminProfileLabels({ logedAdmin, updateAdminHandler }) {
  const name = useRef();
  const surname = useRef();
  const address = useRef();
  const city = useRef();
  const country = useRef();
  const email = useRef();
  const number = useRef();
  const explanation = useRef();
  const money = useRef();
  const percentage = useRef();

  console.log("logedAdmin", logedAdmin);
  console.log("name", name);

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
              placeholder={logedAdmin.name}
            />
          </div>
          <div className="col-md-6">
            <label className="labels">Surname</label>
            <input
              ref={surname}
              type="text"
              className="form-control"
              placeholder={logedAdmin.surname}
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
              placeholder={logedAdmin.address}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">City</label>
            <input
              ref={city}
              type="text"
              className="form-control"
              placeholder={logedAdmin.city}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">Country</label>
            <input
              ref={country}
              type="text"
              className="form-control"
              placeholder={logedAdmin.country}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">Email</label>
            <input
              ref={email}
              type="text"
              className="form-control"
              placeholder={logedAdmin.email}
            />
          </div>

          <div className="col-md-12">
            <label className="labels">Number</label>
            <input
              ref={number}
              type="text"
              className="form-control"
              placeholder={logedAdmin.number}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">Explanation of Registration</label>
            <input
              ref={explanation}
              type="text"
              className="form-control"
              placeholder={logedAdmin.explanation}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">Total money</label>
            <input
              ref={money}
              type="text"
              className="form-control"
              placeholder={logedAdmin.money}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">Percentage of reservations</label>
            <input
              ref={percentage}
              type="text"
              className="form-control"
              placeholder={logedAdmin.percentage}
            />
          </div>
        </div>

        <div className="mt-5 text-center">
          <button
            className="btn btn-success profile-button"
            type="button"
            onClick={() => {
              logedAdmin.name = name.current.value;
              logedAdmin.surname = surname.current.value;
              logedAdmin.address = address.current.value;
              logedAdmin.city = city.current.value;
              logedAdmin.country = country.current.value;
              logedAdmin.email = email.current.value;
              logedAdmin.number = number.current.value;
              logedAdmin.explanation = explanation.current.value;
              logedAdmin.money = money.current.value;
              logedAdmin.percentage = percentage.current.value;
              updateAdminHandler(logedAdmin);
              localStorage.setItem("Admin", JSON.stringify(logedAdmin));
            }}
          >
            Update Profile
          </button>
        </div>
      </div>
    </div>
  );
}
