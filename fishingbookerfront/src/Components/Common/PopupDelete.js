import React, { useRef, useState } from "react";

function PopupDelete({
  removeInstructorHandler,
  removeInstructorDeleteRequestHandler,
  instructorRequest,
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
                // } else if (cottageOwnerRequest != undefined) {
                //   cottageOwnerRequest.refusalReason = reason.current.value;
                //   removeCottageOwnerHandler(cottageOwnerRequest);
                //  } else {
                //   boatOwnerRequest.refusalReason = reason.current.value;
                //   removeBoatOwnerHandler(boatOwnerRequest);
              }
            }
          }}
        >
          Remove User
        </button>
        <button
          className="btn btn-success"
          onClick={(e) => {
            if (reason.current.value == "") {
              alert("You need to fill filed.");
            } else {
              if (instructorRequest != undefined) {
                instructorRequest.refusalReason = reason.current.value;
                removeInstructorDeleteRequestHandler(instructorRequest);
                // } else if (cottageOwnerRequest != undefined) {
                //   cottageOwnerRequest.refusalReason = reason.current.value;
                //   removeCottageOwnerHandler(cottageOwnerRequest);
                //  } else {
                //   boatOwnerRequest.refusalReason = reason.current.value;
                //   removeBoatOwnerHandler(boatOwnerRequest);
              }
            }
          }}
        >
          Reject
        </button>
      </div>
    </div>
  );
}

export default PopupDelete;
