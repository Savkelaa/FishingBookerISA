import React, { useRef, useState } from "react";

function Popup({
  removeCottageOwnerHandler,
  removeBoatOwnerHandler,
  removeInstructorHandler,
  removeClientHandler,
  instructorRequest,
  cottageOwnerRequest,
  boatOwnerRequest,
  clientRequest,
}) {
  const reason = useRef();

  return (
    <div className="popup">
      <div className="popup-inner">
        <h6 for="text">To remove you need to enter Refusal Reason: </h6>
        <input
          ref={reason}
          type="refusalReason"
          className="form-control"
          id="refusalReason"
        />
        <button
          className="btn btn-danger"
          onClick={(e) => {
            if (reason.current.value == "") {
              alert("You need to fill filed.");
            } else {
              if (instructorRequest != undefined) {
                instructorRequest.refusalReason = reason.current.value;
                removeInstructorHandler(instructorRequest);
              } else if (cottageOwnerRequest != undefined) {
                cottageOwnerRequest.refusalReason = reason.current.value;
                removeCottageOwnerHandler(cottageOwnerRequest);
              } else if (clientRequest != undefined) {
                clientRequest.refusalReason = reason.current.value;
                removeClientHandler(clientRequest);
              } else {
                boatOwnerRequest.refusalReason = reason.current.value;
                removeBoatOwnerHandler(boatOwnerRequest);
              }
            }
          }}
        >
          Remove
        </button>
      </div>
    </div>
  );
}

export default Popup;
