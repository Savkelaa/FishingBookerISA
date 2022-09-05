import React, { useRef } from "react";

export default function ClientProfileLabel({
  logedClient,
  sendInstructorDeleteRequestHandler,
  numFishingClass,
  numFishingClassQuick,
  numBoat,
  numBoatQuick,
  numCottage,
  numCottageQuick,
  group,
  updateClientHandler
}) {
  console.log("logedClient", logedClient);
  console.log("groupp", group);
  const deleteReason = useRef();
  const name = useRef();
  const surname = useRef();
  const address = useRef();
  const city = useRef();
  const country = useRef();
  const email = useRef();
  const number = useRef();
  const explanation = useRef();
  const penalty =useRef();
  const loyalty= useRef()

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
              placeholder={logedClient.name}
              //value={logedClient.name}
            />
          </div>
          <div className="col-md-6">
            <label className="labels">Surname</label>
            <input
              ref={surname}
              type="text"
              className="form-control"
              placeholder={logedClient.surname}
              //value={logedClient.surname}
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
              placeholder={logedClient.address}
           //   value={logedClient.address}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">City</label>
            <input
              ref={city}
              type="text"
              className="form-control"
              placeholder={logedClient.city}
             // value={logedClient.city}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">Country</label>
            <input
              ref={country}
              type="text"
              className="form-control"
              placeholder={logedClient.country}
              //value={logedClient.country}
            />
          </div>
      
          <div className="col-md-12">
            <label className="labels">Penalty</label>
            <input
            ref={penalty}
              disabled = 'true'
              type="text"
              className="form-control"
              placeholder={logedClient.penalty}
              value={logedClient.penalty}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">Number</label>
            <input
              ref={number}
              type="text"
              className="form-control"
              placeholder={logedClient.number}
             // value={logedClient.number}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">Explanation of Registration</label>
            <input
            disabled = 'true'
              ref={explanation}
              type="text"
              className="form-control"
              placeholder={logedClient.explanation}
              value={logedClient.explanation}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">Points For Loyalty Program</label>
            <input
            ref={loyalty}
              disabled = 'true'
              type="text"
              className="form-control"
              placeholder="points"
              value={logedClient.points}
            />
          </div>
          <div className="col-md-12">
            <label className="labels">Email</label>
            <input
              ref={email}
              type="text"
              className="form-control"
              disabled = 'true'
              placeholder={logedClient.email}
              value={logedClient.email}
            />
          </div>
        </div>

        <div className="mt-5 text-center">
          <button    className="btn btn-success profile-button"
            type="button"
            onClick={() => {
              if(name.current.value=='' || surname.current.value==''){
                alert("U need to fill at least name and surname")
                return
              }
              logedClient.name = name.current.value;
              logedClient.surname = surname.current.value;
              logedClient.address = address.current.value;
              logedClient.city = city.current.value;
              logedClient.country = country.current.value;
             // logedClient.email = email.current.value;
              logedClient.number = number.current.value;
              logedClient.explanation = explanation.current.value;
              

              localStorage.setItem(
                "Client",
                JSON.stringify(logedClient)
              );

              updateClientHandler(logedClient);
            }}
          >
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
                logedClient.deleteReason = deleteReason.current.value;
                sendInstructorDeleteRequestHandler(logedClient);
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
