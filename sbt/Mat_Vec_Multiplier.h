#ifndef __Mat_Vec_Multiplier__
#define __Mat_Vec_Multiplier__

#include "emulator.h"

class Mat_Vec_Multiplier_t : public mod_t {
 public:
  dat_t<32> Mat_Vec_Multiplier_Add_Node_12__io_vec_out_immed_in;
  dat_t<32> Mat_Vec_Multiplier__io_mat_in_3_0;
  dat_t<32> Mat_Vec_Multiplier_Add_Node_12__io_mat_comp;
  dat_t<32> Mat_Vec_Multiplier__io_vec_in_3;
  dat_t<32> Mat_Vec_Multiplier_Add_Node_12__io_vec_in_comp;
  dat_t<32> Mat_Vec_Multiplier_Add_Node_12__io_vec_out_immed_out;
  dat_t<32> Mat_Vec_Multiplier__io_vec_out_0;
  dat_t<32> Mat_Vec_Multiplier_Add_Node_13__io_vec_out_immed_in;
  dat_t<32> Mat_Vec_Multiplier__io_mat_in_3_1;
  dat_t<32> Mat_Vec_Multiplier_Add_Node_13__io_mat_comp;
  dat_t<32> Mat_Vec_Multiplier_Add_Node_13__io_vec_in_comp;
  dat_t<32> Mat_Vec_Multiplier_Add_Node_13__io_vec_out_immed_out;
  dat_t<32> Mat_Vec_Multiplier__io_vec_out_1;
  dat_t<32> Mat_Vec_Multiplier_Add_Node_14__io_vec_out_immed_in;
  dat_t<32> Mat_Vec_Multiplier__io_mat_in_3_2;
  dat_t<32> Mat_Vec_Multiplier_Add_Node_14__io_mat_comp;
  dat_t<32> Mat_Vec_Multiplier_Add_Node_14__io_vec_in_comp;
  dat_t<32> Mat_Vec_Multiplier_Add_Node_14__io_vec_out_immed_out;
  dat_t<32> Mat_Vec_Multiplier__io_vec_out_2;
  dat_t<32> Mat_Vec_Multiplier_Add_Node_15__io_vec_out_immed_in;
  dat_t<32> Mat_Vec_Multiplier__io_mat_in_3_3;
  dat_t<32> Mat_Vec_Multiplier_Add_Node_15__io_mat_comp;
  dat_t<32> Mat_Vec_Multiplier_Add_Node_15__io_vec_in_comp;
  dat_t<32> Mat_Vec_Multiplier_Add_Node_15__io_vec_out_immed_out;
  dat_t<32> Mat_Vec_Multiplier__io_vec_out_3;

  void init ( bool rand_init = false );
  void clock_lo ( dat_t<1> reset );
  void clock_hi ( dat_t<1> reset );
  void print ( FILE* f );
  bool scan ( FILE* f );
  void dump ( FILE* f, int t );
};

#endif
