const axios = require("axios");

const boatServices = {
  getAllBoats: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}boats`);
  },

  addBoat: (boat) => {
    return axios.post(`${process.env.REACT_APP_API_URL}boats`, boat);
  },
  deleteBoat: (boatID) => {
    return axios.delete(
      `${process.env.REACT_APP_API_URL}boats/${boatID}`
    );
  },
  updateBoat: (boat) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}boats/${boat.id}`,
      boat
    );
  },
  getBoatsByOwner: (boatOwnerId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}boatsByOwner?boatOwnerId=${boatOwnerId}`
    );
  },
  getBoatsById: (boatId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}boats/${boatId}`
    );
  },
  getBehavioralRuleByBoat: (boatId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}boatBehavioralRulesByBoat?boatId=${boatId}`
    )
  },
  getAdditionalServicesByBoat: (boatId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}additionalServicesByBoat?boatId=${boatId}`
    )
  },

  getImagesByBoat: (boatId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}boatImage?boatId=${boatId}`
    )
  },

  getWeeklyNumReservationsByBoat: (boatId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}weeklyBoatReservation?boatId=${boatId}`
    )
  },

  getMonthlyNumReservationsByBoat: (boatId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}monthlyBoatReservation?boatId=${boatId}`
    )
  },

  getYearlyNumReservationsByBoat: (boatId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}yearlyBoatReservation?boatId=${boatId}`
    )
  },

  searchBoatByName: (boatOwnerId, boatName) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}boatsByOwnerAndName?boatOwnerId=${boatOwnerId}&boatName=${boatName}`
    );
  },

  getFishingEquipmentBoat: () => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}fishingEquipmentsBoat`
    );
  },

  getYearlyIncomeByBoat: (boatId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}yearlyBoatIncome?boatId=${boatId}`
    )
  },

  getMonthlyIncomeByBoat: (boatId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}monthlyBoatIncome?boatId=${boatId}`
    )
  },

  getWeeklyIncomeByBoat: (boatId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}weeklyBoatIncome?boatId=${boatId}`
    )
  },

};

export default boatServices;
